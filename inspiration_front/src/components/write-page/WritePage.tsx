import React from 'react';
import "./WritePage.css";
import MyPanel from "../../styles/common-components/my-panel/MyPanel";
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyComponentField from "../../styles/common-components/my-component/MyComponent";
import {testText} from "../../test/TestText";
function WritePage() {
    return (
        <div className="write-page">
            <div className="write-page-back-button-wrapper">
                <MyButton
                    name="Back to stories"
                    path="../main-writer-page"
                    backgroundColor="var(--wr-secondary-main)"
                    color="var(--wr-text-secondary)"
                />
            </div>

            <div className="write-page-panel-wrapper">
                <MyPanel
                    style="write-page-panel-components-wrapper"
                    components={[
                        <div className="write-page-story-name-wrapper">
                            <MyComponentField
                                name="Story name very long story name"
                                backgroundColor="var(--wr-primary-middle)"
                                color="var(--wr-text-title)"
                            />
                        </div>,
                        <div className="write-page-story-chapter-and-episode-wrapper">
                            <MyComponentField
                                name="Chapter 1000"
                                backgroundColor="var(--wr-secondary-middle)"
                                color="var(--wr-text-title)"
                            />
                        </div>,
                        <div className="write-page-story-chapter-and-episode-wrapper">
                            <MyComponentField
                                name="Episode 1000"
                                backgroundColor="var(--wr-secondary-middle)"
                                color="var(--wr-text-title)"
                            />
                        </div>,
                        <div className="write-page-story-load-picture-wrapper">
                            <MyButton
                                name="Load picture"
                                path="../"
                                backgroundColor="var(--wr-secondary-middle)"
                                color="var(--wr-text-title)"
                            />
                        </div>
                    ]}
                />
            </div>

            <div className="write-page-text-field">
                <div className="write-page-text">
                    {testText}
                </div>
            </div>
        </div>
    )
}


export default WritePage;