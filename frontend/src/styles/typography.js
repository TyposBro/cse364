import { css } from "styled-components";

//! ********************DISCLAIMER********************
//*  In this project 1rem == 10px
//~  (see: src/styles/reset.js)
//*  1rem == 16px (Browser defaults)
//! ********************DISCLAIMER********************

//^ HEADER
const header_01 = css`
  font-family: "Noto Sans Display", sans-serif;
  font-weight: 700;
  line-height: 4.4rem;
  font-size: 3.6rem;
`;

const header_02 = css`
  font-family: "Noto Sans Display", sans-serif;
  font-weight: 600;
  line-height: 3.2rem;
  font-size: 2.4rem;
`;
const header_03 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 600;
  line-height: 2.4rem;
  font-size: 2rem;
`;
const header_04 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 700;
  line-height: 2.4rem;
  font-size: 1.6rem;
`;

//& BODY
const body_01_600 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 600;
  line-height: 2.4rem;
  font-size: 1.6rem;
`;

const body_01_400 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 400;
  line-height: 2.4rem;
  font-size: 1.6rem;
`;

const body_02_600 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 600;
  line-height: 2.4rem;
  font-size: 1.4rem;
`;

const body_02_400 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 400;
  line-height: 2.4rem;
  font-size: 1.4rem;
`;

const caption_01 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 400;
  line-height: 2rem;
  font-size: 1.4rem;
`;

const caption_02 = css`
  font-family: "Noto Sans", sans-serif;
  font-weight: 400;
  line-height: 1.6rem;
  font-size: 1.2rem;
`;

export default {
  header_01,
  header_02,
  header_03,
  header_04,
  body_01_600,
  body_01_400,
  body_02_600,
  body_02_400,
  caption_01,
  caption_02,
};
