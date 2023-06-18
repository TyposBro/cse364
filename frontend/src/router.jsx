import { createBrowserRouter } from "react-router-dom";
import Record from "./pages/record";
import Edit from "./pages/edit";
import Calendar from "./pages/calendar";

export const router = createBrowserRouter([
  {
    path: "/record",
    Component: Record,
  },
  {
    path: "/calendar",
    Component: Calendar,
  },
  {
    path: "/edit",
    Component: Edit,
  },

  {
    path: "/",
    Component: Record,
  },
]);

export default router;
