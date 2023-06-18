import styled, { css } from "styled-components";

import { MdForward10, MdReplay10 } from "react-icons/md";
import { FaPause, FaPlay } from "react-icons/fa";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: stretch;
  /* padding: 4rem 2rem; */
  width: 100%;
  /* justify-content: space-around; */
`;
export const Controls = styled.div`
  display: flex;
  align-self: center;
`;

const icon = css`
  font-size: 3rem;
  margin: 1rem;
  cursor: pointer;
  color: rgba(var(--text-color));
`;

export const Forward10 = styled(MdForward10)`
  ${icon}
`;

export const Replay10 = styled(MdReplay10)`
  ${icon}
`;

export const Play = styled(FaPlay)`
  ${icon}
`;
export const Pause = styled(FaPause)`
  ${icon}
`;
