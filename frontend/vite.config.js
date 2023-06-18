import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import path from "path";

// https://vitejs.dev/config/

export default defineConfig({
  server: {
    port: 3000,
    host: "0.0.0.0",
  },
  plugins: [
    react({
      include: "**/*.{jsx,tsx,js}",
      babel: {
        plugins: ["babel-plugin-styled-components"],
      },
    }),
  ],
  resolve: {
    alias: {
      auth: path.resolve(__dirname, "./src/auth"),
      calendar: path.resolve(__dirname, "./src/calendar"),
      components: path.resolve(__dirname, "./src/components"),
      edit: path.resolve(__dirname, "./src/edit"),
      hooks: path.resolve(__dirname, "./src/hooks"),
      handlers: path.resolve(__dirname, "./src/handlers"),
      record: path.resolve(__dirname, "./src/record"),
      styles: path.resolve(__dirname, "./src/styles"),
      state: path.resolve(__dirname, "./src/state"),
      utils: path.resolve(__dirname, "./src/utils"),
    },
  },
});
