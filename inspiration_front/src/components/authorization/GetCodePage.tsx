import React from 'react';
import "./AuthorizationPage.css";
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyInputField from "../../styles/common-components/my-input-field/InputField";
import MyPanel from "../../styles/common-components/my-panel/MyPanel";
import MyTitle from "../../styles/common-components/my-title/MyTitle";
import MyComment from "../../styles/common-components/my-comment/MyComment";

function GetCodePage() {
    return (
        <div className="authorization-style-img">
            <div className="authorization-style-gradient">

                <div className="authorization-style-button-position">
                    <MyButton
                        name="Back"
                        path="/main-reader-page/authorization-page"
                        backgroundColor="var(--rg-secondary-main)"
                        color="var(--rg-text-secondary)"
                    />
                </div>

                <div className="authorization-style-panel-position">
                    <div className="get-code-page-panel-proportions">
                        <div className="get-code-page-title-wrapper">
                            <MyTitle
                                color=""
                                name="Inspiration"
                            />
                        </div>
                        <MyPanel
                            style="get-code-page-panel-components-wrapper"
                            components={[
                                <MyInputField
                                    name="code"
                                    backgroundColor="var(--rg-secondary-main)"
                                />,
                                <MyComment
                                    text="We have sent the code to your email"
                                    color="var(--rg-text-secondary)"
                                />
                            ]}
                        />
                    </div>
                </div>
            </div>
        </div>
    )
}
export default GetCodePage;