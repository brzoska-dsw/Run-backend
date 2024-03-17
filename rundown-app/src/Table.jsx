import { Box } from "@mui/material";
import React, { useEffect, useState } from "react";

function Table({ columns, data, callback }) {
  const [indexTr, setIndexTr] = useState(0);
  const [indexTd, setIndexTd] = useState(0);
  const [bgColor, setBgColor] = useState();

  useEffect(() => callback(indexTr, indexTd), [callback, indexTr, indexTd]);

  const handleClick = (trIndex, tdIndex, e) => {
    setIndexTd(trIndex);
    setIndexTr(tdIndex);

    const color = window.getComputedStyle(e.target, null).backgroundColor;

    setBgColor(() => color);

    e.currentTarget.style.backgroundColor = "rgba(250,0,250,0.5)";
  };

  const handleBlur = (e) => {
    e.currentTarget.style.backgroundColor = bgColor;
  };

  return (
    <Box
      style={{
        display: "flex",
        justifyContent: "center",
        margin: 10,
        textAlign: "center",
        maxHeight: "521px",
        overflowY: "scroll",
      }}
    >
      <table
        style={{
          border: "1px solid black",
          borderCollapse: "collapse",
        }}
      >
        <thead>
          <tr>
            {columns.map((col, i) => (
              <td
                key={i}
                style={{
                  border: "1px solid black",
                  textAlign: "center",
                  fontWeight: 800,
                  padding: 5,
                  fontSize: 20,
                }}
              >
                <div>{col}</div>
              </td>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((row, trIndex) => (
            <tr key={trIndex} id={trIndex}>
              {Object.values(row).map((cell, tdIndex) => (
                <td
                  suppressContentEditableWarning={true}
                  style={{
                    border: "1px solid black",
                    textAlign: "center",
                    paddingLeft: 10,
                    paddingRight: 10,
                  }}
                  id={tdIndex}
                  key={tdIndex}
                  onFocus={(e) => handleClick(trIndex, tdIndex, e)}
                  onBlur={(e) => handleBlur(e)}
                  contentEditable
                >
                  {cell}
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    </Box>
  );
}

export default Table;
