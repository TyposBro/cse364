import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { useAtom } from "jotai";
import { useAudioRecorder } from "react-audio-voice-recorder";
import { v4 as uuidv4 } from "uuid";

import { BsXLg, BsMicFill, BsPlusLg, BsPauseFill, BsStopFill } from "react-icons/bs";
import { AiOutlineCheck } from "react-icons/ai";

import { blobAtom, timestampsAtom, toggleAtom } from "state";
import { getFormatedTime } from "utils/time";
import { Icon, Timestamps } from "components";
import {
  ButtonGroup,
  _checkbox,
  Page,
  MetaInfo,
  Timer,
  Input,
  IconContainer,
  ListItem,
} from "./index.styled";

const Record = () => {
  const {
    startRecording,
    stopRecording,
    togglePauseResume,
    recordingBlob,
    isRecording,
    isPaused,
    recordingTime,
  } = useAudioRecorder();

  const [timestamps, setTimestamps] = useAtom(timestampsAtom);
  const [toggleInput, setToggleInput] = useAtom(toggleAtom);
  const [value, setValue] = useState("");
  const [blob, setBlob] = useAtom(blobAtom);

  const [save, setSave] = useState(false);

  const navigate = useNavigate();

  const handleDiscard = () => {
    stopRecording();
    setTimestamps([]);
    setSave(false);
    setToggleInput(false);
  };

  const handleSave = () => {
    stopRecording();
    setSave(true);
    setToggleInput(false);
  };

  useEffect(() => {
    //* recording isn't ready or user pressed discard
    if (!recordingBlob || !save) return;

    //* recording is over and user pressed save
    // setBlob(recordingBlob);
    setBlob(recordingBlob);
    navigate("/edit");
  }, [recordingBlob]);

  //********************* RECORDING STATES ***********************
  const initState = () => (
    <Icon
      onClick={startRecording}
      style={{ marginTop: "-5rem" }}
      icon={BsMicFill}
      size="lg"
      bgc="brand"
    />
  );
  const recordingState = () => {
    return (
      <>
        <Icon onClick={stopRecording} icon={BsStopFill} bgc="dim" size="md">
          Stop
        </Icon>

        <Icon
          onClick={togglePauseResume}
          style={{ marginTop: "-5rem" }}
          icon={BsPauseFill}
          size="lg"
          bgc="brand"
        />

        <Icon icon={BsPlusLg} onClick={() => setToggleInput(true)} bgc="dim" size="md">
          Add
        </Icon>
      </>
    );
  };
  const pausedState = () => {
    return (
      <>
        <Icon onClick={handleDiscard} icon={BsXLg} bgc="dim" size="md">
          Discard
        </Icon>

        <Icon
          onClick={togglePauseResume}
          style={{ marginTop: "-5rem" }}
          icon={BsMicFill}
          size="lg"
          bgc="brand"
        />

        <Icon onClick={handleSave} icon={AiOutlineCheck} bgc="dim" size="md">
          Save
        </Icon>
      </>
    );
  };

  return (
    <Page>
      <MetaInfo>
        <Timer>{getFormatedTime(recordingTime)}</Timer>
      </MetaInfo>
      <Timestamps>
        <ListItem
          onClick={
            toggleInput
              ? () => console.log("toggleInput: True")
              : () => setToggleInput((prev) => !prev)
          }
        >
          <IconContainer border="brand" bgc="brand">
            <BsPlusLg style={{ fill: "rgba(var(--text-color))" }} />
          </IconContainer>
          {toggleInput ? (
            <Input
              onChange={({ target }) => setValue(target.value)}
              onKeyDown={(e) => {
                if (e.key === "Enter" || e.code === "Enter" || e.keyCode === 13) {
                  setTimestamps((prev) => [
                    { id: uuidv4(), tag: value, time: recordingTime },
                    ...prev,
                  ]);
                  setToggleInput(false);
                }
              }}
              autoFocus
              placeholder="Press enter to add a tag"
            />
          ) : (
            <span>Add a tag</span>
          )}
        </ListItem>
      </Timestamps>
      <ButtonGroup>
        {!isRecording && initState()}
        {isRecording && !isPaused && recordingState()}
        {isRecording && isPaused && pausedState()}
      </ButtonGroup>
    </Page>
  );
};

export default Record;
