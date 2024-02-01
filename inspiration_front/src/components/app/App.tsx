import React, {useEffect, useState} from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";

import MainReaderPage from "../main-reader-page/MainReaderPage";
import ReadPage from "../read-page/ReadPage";
import MainWriterPageAlreadyWritten from "../main-writer-page/MainWriterPageAlreadyWritten";
import WritePage from "../write-page/WritePage";
import RegistrationPage from "../authorization/RegistrationPage";
import AuthorizationPage from "../authorization/AuthorizationPage";
import NameRestorationPage from "../authorization/NameRestorationPage";
import PasswordRestorationPage from '../authorization/PasswordRestorationPage';
import GetCodePage from "../authorization/GetCodePage";
import SetNewNamePage from "../authorization/SetNewNamePage";
import SetNewPasswordPage from "../authorization/SetNewPasswordPage";
import MainWriterPageInProgress
    from "../main-writer-page/MainWriterPageInProgress";
function App() {

    return (
      <div className="App">
          <BrowserRouter>
              <Routes>
                  <Route path="/" element={<MainReaderPage />} />
                  <Route path="/main-reader-page" element={<MainReaderPage />} />
                  <Route path="/read-page" element={<ReadPage />} />
                  <Route path="/main-reader-page/read-page" element={<ReadPage />} />
                  <Route path="/main-writer-page" element={<MainWriterPageAlreadyWritten />} />
                  <Route path="/main-writer-page/in-progress" element={<MainWriterPageInProgress />} />

                  <Route path="/main-writer-page/write-page" element={<WritePage />} />

                  <Route path="/main-reader-page/authorization-page/registration-page" element={<RegistrationPage/>} />
                  <Route path="/main-reader-page/authorization-page" element={<AuthorizationPage/>} />
                  <Route path="/main-reader-page/authorization-page/name-restoration" element={<NameRestorationPage/>} />
                  <Route path="/main-reader-page/authorization-page/password-restoration" element={<PasswordRestorationPage/>} />
                  <Route path="/main-reader-page/authorization-page/get-code" element={<GetCodePage/>} />
                  <Route path="/main-reader-page/authorization-page/set-new-name" element={<SetNewNamePage/>} />
                  <Route path="/main-reader-page/authorization-page/set-new-password" element={<SetNewPasswordPage/>} />
              </Routes>
          </BrowserRouter>
      </div>
  );
}

export default App;

