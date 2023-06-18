import { Container, IconContainer } from "./index.styled";

export const Icon = ({ icon, children, container, ...props }) => {
  return (
    <Container {...{ container }}>
      <IconContainer {...props}>{icon()}</IconContainer>
      {children}
    </Container>
  );
};

export default Icon;
