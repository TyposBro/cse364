import React, { useEffect, useRef, useState } from "react";
import { v4 as uuid } from "uuid";

import WaveSurfer from "wavesurfer.js";
import RegionsPlugin from "wavesurfer.js/dist/plugin/wavesurfer.regions.min.js";
import TimelinePlugin from "wavesurfer.js/dist/plugin/wavesurfer.timeline.min.js";

import { Container, Controls, Forward10, Pause, Play, Replay10 } from "./index.styled";
import { useAtom } from "jotai";
import { blobAtom, timestampsAtom } from "state";
import { useAudioRecorder } from "react-audio-voice-recorder";
import { redirect, useNavigate } from "react-router";

const bg = "rgba(6, 7, 13, 1)";
const dim = "rgba(22, 26, 31, 1)";
const dimmer = "rgba(34, 39, 43, 1)";
const text = "rgba(250, 239, 221, 1)";
const brand = "rgba(0, 229, 139, 1)";
const contrast = "rgba(240, 235, 141, 1)";

const getRegions = (timestamps) => {
  const regions = timestamps?.map((item) => ({
    start: item?.time,
    end: item?.time + 60,
    loop: false,
    color: "rgba(0, 229, 139, 0.5)",
    id: item?.id,
    data: item?.tag,
    // resize: false,
    // drag: false,
  }));

  return RegionsPlugin.create({
    regionsMinLength: 2,
    regions: regions,
    resize: false,
    drag: false,
  });
};

const getOptions = (ref, plugins = []) => {
  return {
    container: ref,
    waveColor: "rgba(250, 239, 221, 0.5)",
    progressColor: brand,
    cursorColor: brand,
    barWidth: 3,
    barRadius: 3,
    responsive: true,
    interact: true,
    height: 50,
    // If true, normalize by the maximum peak instead of 1.0.
    normalize: true,
    // Use the PeakCache to improve rendering speed of large waveforms.
    partialRender: true,
    plugins: plugins,
  };
};

export default function Waveform() {
  const [timestamps, setTimestamps] = useAtom(timestampsAtom);
  const [blob, setBlob] = useAtom(blobAtom);

  const navigate = useNavigate();
  const waveformRef = useRef(null);
  const wavesurfer = useRef(null);
  const timelineRef = useRef(null);

  const [play, setPlay] = useState(false);

  // create new WaveSurfer instance
  // On component mount and when url changes
  useEffect(() => {
    if (!blob) {
      console.log("no blob");
      navigate("/");
      return;
    }
    const regions = getRegions(timestamps);
    const timeline = TimelinePlugin.create({
      container: timelineRef.current,
      primaryColor: text,
      secondaryColor: text,
      primaryFontColor: text,
      secondaryFontColor: text,
    });
    const options = getOptions(waveformRef.current, [regions, timeline]);
    wavesurfer.current = WaveSurfer.create(options);

    //* FIXME: load from firebase
    wavesurfer.current.loadBlob(blob);

    wavesurfer.current.on("ready", () => {
      console.log("READY");
      setPlay(false);
      wavesurfer.current.setVolume(1);
    });
    // Removes events, elements and disconnects Web Audio nodes.
    // when component unmount
    return () => wavesurfer.current.destroy();
  }, [blob, timestamps]);

  const handlePlayPause = () => {
    if (!play) {
      wavesurfer.current.playPause();
      setPlay(true);
    } else {
      setPlay(false);
      wavesurfer.current.playPause();
    }
    console.log(wavesurfer.current.regions.list);
    console.log(timestamps);
  };
  return (
    <Container>
      <div id="waveform" ref={waveformRef} />
      <div id="timeline" ref={timelineRef}></div>
      <Controls>
        <Replay10 onClick={() => wavesurfer.current.skip(-10)} />
        {play ? <Pause onClick={handlePlayPause} /> : <Play onClick={handlePlayPause} />}
        <Forward10 onClick={() => wavesurfer.current.skip(10)} />
      </Controls>
    </Container>
  );
}
