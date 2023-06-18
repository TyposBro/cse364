import { useState } from "react";

import { v4 as uuidv4 } from "uuid";

import { BsFillTrash3Fill } from "react-icons/bs";

import { timestampsAtom } from "state";
import { _checkbox, List, ListItem, Label, Checkbox, Input } from "./index.styled";
import { useAtom } from "jotai";

export const Timestamps = (props) => {
  const [timestamps, setTimestamps] = useAtom(timestampsAtom);
  const [toggleInput, setToggleInput] = useState(null);
  const [value, setValue] = useState("");

  const handleKeyDown = (e) => {
    if (e.key === "Enter" || e.code === "Enter" || e.keyCode === 13) {
      setTimestamps((prev) =>
        prev.map((tag) => {
          if (tag?.id === toggleInput) {
            tag.tag = value;
          }
          return tag;
        })
      );
      setToggleInput(null);
    }
  };

  return (
    <List>
      {props.children ?? null}

      {timestamps.map((e) => (
        <ListItem key={e?.id}>
          <Checkbox border="text" />
          {toggleInput === e?.id ? (
            <Input
              onChange={({ target }) => setValue(target.value)}
              value={value}
              onKeyDown={handleKeyDown}
              autoFocus
              placeholder="Press enter to add a tag"
            />
          ) : (
            <Label
              onClick={() => {
                setToggleInput(e?.id);
                setValue(e?.tag);
              }}
              style={{ flexGrow: "1" }}
            >
              {e?.tag}
            </Label>
          )}

          <BsFillTrash3Fill
            onClick={() => {
              setTimestamps((prev) => prev.filter((tag) => tag?.id !== e?.id));
            }}
            style={{ width: "2rem", height: "2rem", fill: "rgba(var(--text-color))" }}
          />
        </ListItem>
      ))}
    </List>
  );
};

export default Timestamps;
