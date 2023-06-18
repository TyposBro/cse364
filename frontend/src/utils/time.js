export function formatTime(time) {
  return time < 10 ? `0${time}` : time;
}

export function getFormatedTime(time) {
  const hh = formatTime(Math.floor(time / 3600));
  const mm = formatTime(Math.floor(time / 60));
  const ss = formatTime(time % 60);

  return `${hh}:${mm}:${ss}`;
}
