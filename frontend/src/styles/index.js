import { createGlobalStyle } from "styled-components";
import { reset } from "./reset";

export default createGlobalStyle`

${reset}
`;

export { default as typography } from "./typography";
