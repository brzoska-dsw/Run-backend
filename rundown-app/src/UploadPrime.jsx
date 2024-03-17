import React, { useRef } from "react";
import { Toast } from "primereact/toast";
import { FileUpload } from "primereact/fileupload";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import "primeflex/primeflex.css";
import "./UploadPrime.css";


function UploadPrime( {name, url} ) {
  const toast = useRef(null);

  const onUpload = (e) => {
    console.log(e);
    toast.current.show({
      severity: "info",
      summary: "Success",
      detail: "File Uploaded",
    });
  };
;
  return (
    <div >
      <h1 className="flex justify-content-center">{name}</h1>
      <div className="card flex justify-content-center">
        <Toast ref={toast}></Toast>
        <FileUpload
          maxFileSize={1000000}
          name="file"
          url={url}
          accept="text/csv"
          onUpload={onUpload}
          emptyTemplate={<p className="m-1">Drag&Drop files here to upload.</p>}
        />
      </div>
    </div>
  );
}

export default UploadPrime;
