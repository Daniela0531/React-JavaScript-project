import React from 'react';
import './MainReaderPage.css';
import "react-dom"
import "../../styles/colors.css"
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyInputField from "../../styles/common-components/my-input-field/InputField";
import TestStoriesReader from "../../test/TestStoriesReader";

function MainReaderPage() {
    return (
        <div className="main-reader-page">

            <div className="main-reader-page-writer-mode-wrapper">
                <MyButton
                    name="Write mode"
                    path="../main-reader-page/authorization-page"
                    color="var(--rm-text-secondary)"
                    backgroundColor="var(--rm-secondary-main)"/>
            </div>

            <div className="main-reader-page-panel">
                {[
                    <div className="main-reader-page-search-wrapper">
                        <MyInputField name="Search" backgroundColor="var(--rm-primary-main)" />
                    </div>
                ]}
            </div>

            <div className="main-reader-page-big-panel">
                <TestStoriesReader/>
            </div>
        </div>
    )
}


export default MainReaderPage;