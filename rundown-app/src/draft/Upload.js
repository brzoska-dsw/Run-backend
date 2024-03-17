import axios from "axios";
import React, { useState } from "react";
import { useAlert } from "react-alert";
import "./Upload.css";
import Tables from "../Tables";
import Button from "@mui/material/Button";

function Upload() {
  const [file, setFile] = useState();
  const [calendarDates, setCalendarDates] = useState([]);
  const alert = useAlert();
  const [uploadProgress, setUploadProgress] = useState(0);

  const url = "http://localhost:8080/uploads/calendar";

  function showAlert() {
    alert.show("completed", {
      type: "success",
      timeout: 5000,
      position: "middle",
      transition: "fade",
      onClose: () => {
        setUploadProgress(0);
      },
    });
  }

  function handleChange(e) {
    if (e.target.files) {
    setFile(e.target.files[0]);
    }
  }

  async function handleSubmit(event) {
    event.preventDefault();

    const formData = new FormData();
    formData.append("file", file);
    formData.append("fileName", file.name);

    const config = {
      headers: {
        "content-type": "multipart/form-data",
      },
      onUploadProgress: function (e) {
        const percentCompleted = Math.round(
          (e.loaded * 100) / e.total
        );
        setUploadProgress(percentCompleted);
      },
    };
    await axios 
      .post(url, formData, config)
      .then(() => {
        showAlert();
      })
      .catch((err) => {
        console.log(err);
      });
  }

  const handleOnClicButton = async () => {
    await axios
      .get(url)
      .then((res) => {
        setCalendarDates(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="upload">
      <div className="format">
        <h1>File Upload</h1>
        <input
          id="file"
          type="file"
          onChange={handleChange}
          accept="text/csv"
        />
        <button type="submit" onClick={handleSubmit}>
          Upload
        </button>
      </div>
      <div className="progress">
        <label>progress</label>
         <progress
          value={uploadProgress}
          max="100"
          style={{ marginLeft: 20 }}
        ></progress>
      </div>
      <div>
        <Button size="small" variant="contained" onClick={handleOnClicButton}>
          Return Data
        </Button>
      </div>
      <div>
        <Tables DaTa={calendarDates} />
      </div>
    </div>
  );
}

export default Upload;
