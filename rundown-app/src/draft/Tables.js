import { useTable } from "react-table";
import React from "react";
import { Box } from "@mui/material";
import { useMemo } from "react";

function Tables({ DaTa }) {
  const data = useMemo(() => DaTa, [DaTa]);
  const columns = useMemo(
    () => [
      {
        Header: "ID",
        accessor: "id",
      },
      {
        Header: "Date",
        accessor: "date",
      },
      {
        Header: "Production",
        accessor: "production",
      },
      {
        Header: "Vanning",
        accessor: "vanning",
      },
    ],
    []
  );
  console.log(data);
  console.log(columns);

  const { getTableProps, getTableBodyProps, headerGroups, rows, prepareRow } =
    useTable({ columns, data });

  return (
    <Box sx={{margin: "20px"}}>
      <div className="App">
        <div className="container">
          <table style={{border: "1px solid black" }} {...getTableProps()}>
            <thead>
              {headerGroups.map((headerGroup) => (
                <tr {...headerGroup.getHeaderGroupProps()}>
                  {headerGroup.headers.map((column) => (
                    <th {...column.getHeaderProps()}>
                      {column.render("Header")}
                    </th>
                  ))}
                </tr>
              ))}
            </thead>
            <tbody {...getTableBodyProps()}>
              {rows.map((row) => {
                prepareRow(row);
                return (
                  <tr {...row.getRowProps()}>
                    {row.cells.map((cell) => (
                      <td {...cell.getCellProps()}> {cell.render("Cell")} </td>
                    ))}
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>

      {/* <div>{JSON.stringify(data)}</div> */}
    </Box>
  );
}

export default Tables;
