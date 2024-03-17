import { Box } from "@mui/material";
import UploadModule from "./UploadModule";


export default function Home() {

  const colCalendar = ["Id", "Date", "Vanning", "Production"];
  const colRundown = ["Id", "Vanning", "Loading", "Unloading"];
  const colProdplan = ["Id", "Date", "Value"];

  return (
    <Box 
      sx={{
        display: "flex",
        alignItems: "stretch",
        justifyContent: "space-evenly",
        hight: "100%  ",
        backgroundColor: "yellow",
        marginTop: "0px",
        marginBottom: "0px",
        marginLeft: "0px",
        marginRight: "0px"
      }}
      >
      <Box
        sx={{
          display: "flex",
          flexGrow: 1,
          backgroundColor: "tomato",
          height: "900px",
        }}
      ></Box>
      <Box sx={{display: "flex", backgroundColor: "plum", maxHeight: "900px"}}>
        <UploadModule
          columns={colCalendar}
          name="Upload Calendar"
          url={"http://localhost:8080/calendar"}
        />
        <UploadModule
          columns={colRundown}  
          name="Upload Rundown"
          url={"http://localhost:8080/rundown"}
        />
        <UploadModule
          columns={colProdplan}
          name="Upload Production Plan"
          url={"http://localhost:8080/prodplan"}
        />
      </Box>
    </Box>
  );
}
