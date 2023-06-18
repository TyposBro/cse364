import styled from "styled-components";
import { typography } from "styles";

export const Page = styled.div`
  ${typography.body_01_400}
  height: 100vh;
  width: 100vw;
  padding: 3rem;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  background-color: rgba(var(--bg-color));
`;

export const MetaInfo = styled.div`
  display: flex;
  justify-content: center;
  color: rgba(var(--text-color));
`;

export const Timer = styled.div`
  ${typography.header_01}
  letter-spacing: 1px;
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

export const ButtonGroup = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-around;
  align-items: center;
`;

export const ModalContent = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  background-color: rgba(var(--bg-color));
  :has(.modal-content) {
    background-color: transparent;
  }

  padding: 1rem;
  border-radius: 0.8rem;
`;

export const InputGroup = styled.div`
  width: 100%;
  height: 5rem;
  display: flex;
  justify-content: center;
  ${typography.body_01_600}
  color: white;
`;
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

export const CheckboxContent = styled.span`
  position: absolute;
`;
