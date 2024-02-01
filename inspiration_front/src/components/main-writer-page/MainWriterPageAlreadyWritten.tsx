import React, {useState} from 'react';
import './MainWriterPage.css';
import "react-dom"
import "../../styles/colors.css"
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyInputField from "../../styles/common-components/my-input-field/InputField";
import MyComponentField from "../../styles/common-components/my-component/MyComponent";
import {stories} from "../../test/TestStoriesWriter";
import MyStoryGrid from "../../styles/common-components/my-story-grid/StoryGrid";

function MainWriterPageAlreadyWritten() {
    return (
        <div className="main-writer-page">

            <div className="main-reader-page-writer-mode-wrapper">
                <MyButton
                    name="Reader mode"
                    path="../main-reader-page"
                    color="var(--wr-text-secondary)"
                    backgroundColor="var(--wr-secondary-main)"/>
            </div>

            <div className="main-writer-page-panel">
                <div className="main-writer-page-components-wrapper">
                    {[
                        <div className="main-writer-page-search-wrapper">
                            <MyInputField name="Search" backgroundColor="var(--wr-primary-main)" />
                        </div>,
                        <div className="main-writer-page-button-wrapper">
                            <MyComponentField
                                name="Already written"
                                backgroundColor="var(--wr-primary-main)"/>
                        </div>,
                        <div className="main-writer-page-button-wrapper">
                            <MyButton
                                name="In progress"
                                path="/main-writer-page/in-progress"
                                backgroundColor="var(--wr-primary-main)"/>
                        </div>
                    ]}
                </div>
            </div>

            <div className="main-writer-page-stories">
                <MyStoryGrid stories={stories}/>
            </div>
        </div>
    )
}


export default MainWriterPageAlreadyWritten;