import { Box, Button } from "@mui/material";
import axios from "axios";
import React, { useState } from "react";
import UploadPrime from "./UploadPrime";
import Table from "./Table";

function UploadModule({ columns, name, url }) {
  const [data, setData] = useState([]);
  const [itr, setItr] = useState(" ");
  const [itd, setItd] = useState(" ");

  const callback = (itr, itd) => {
    setItr(itr);
    setItd(itd);
  };

  const handleOnClicButton = async () => {
    await axios
      .get(url)
      .then((res) => {
        setData(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <Box>
      <UploadPrime name={name} url={url} />
      <Box style={{fontSize:"20px", display: "flex", flexGrow:"1"}}>
        <Button
          style={{ marginLeft: 25, flow: "left" }}
          variant="contained"
          onClick={handleOnClicButton}
        >
          SHOW
        </Button>
        <Box style={{margin :"10px"}}>
          {`Row: ${itd + 1}, Column: ${itr + 1}`}
        </Box>
      </Box>

      <Table columns={columns} data={data} callback={callback} />
    </Box>
  );
}

export default UploadModule;
