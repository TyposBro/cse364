import styled from "styled-components";
import { typography } from "styles";

export const Input = styled.input`
  background-color: transparent;
  border: none;
  outline: none;
  color: rgba(var(--text-color));
  ::placeholder {
    color: rgba(var(--text-color), 0.7);
  }
`;

export const IconContainer = styled.div`
  width: 2.5rem;
  height: 2.5rem;

  background-color: ${({ bgc }) => (bgc ? `rgba(var(--${bgc}-color));` : "transparent;")};
  border: 1px solid ${({ border }) => (border ? `rgba(var(--${border}-color));` : "transparent")};
  box-sizing: border-box;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 1rem;
  flex-shrink: 0;
`;

export const Checkbox = styled(IconContainer)`
  position: relative;
`;

export const List = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  margin: 3rem 0;
`;
export const ListItem = styled.div`
  color: rgba(var(--text-color));
  display: flex;
  align-items: center;
  /* justify-content: space-between; */
  padding: 1rem;
  border-radius: 0.4rem;
  border: 0.5px solid #cac7c7;
  margin: 0.5rem 0;
  font-size: 19px;
  background-color: rgba(var(--dim-color));
  /* background-color: ; */
  ${typography.body_01_400} /* ${typography.caption_01} */
  font-size: 2rem;

  /* span {
    color: rgba(var(--brand-color));
  } */
`;
export const _checkbox = styled.input.attrs({ type: "checkbox" })`
  display: none;
`;
export const Label = styled.div`
  color: rgba(var(--text-color));
`;
