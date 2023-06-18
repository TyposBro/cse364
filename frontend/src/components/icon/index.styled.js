import { Button as Btn } from "react-bootstrap";
import styled, { css } from "styled-components";
import { typography } from "styles";

const sm = css`
  width: 3rem;
  height: 3rem;
  font-size: 2rem;
`;
const md = css`
  width: 5rem;
  height: 5rem;
  font-size: 3rem;
`;
const lg = css`
  width: 9rem;
  height: 9rem;
  font-size: 5rem;
`;

export const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: rgba(var(--text-color));
  ${typography.caption_02}

  ${({ container }) => container}
`;

export const IconContainer = styled(Btn)`
  border-radius: 50%;
  display: grid;
  place-content: center;
  border: none;

  &,
  &:hover,
  &:active,
  &:focus {
    background-color: ${({ bgc }) => `rgba(var(--${bgc}-color));`} !important;
  }

  ${({ size }) => {
    switch (size) {
      case "sm":
        return sm;
      case "md":
        return md;
      case "lg":
        return lg;

      default:
        return size;
    }
  }};
`;
