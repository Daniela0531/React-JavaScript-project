import React from 'react';
import "./AuthorizationPage.css";
import MyLink from "../../styles/common-components/my-link/MyLink";
import MyButton from "../../styles/common-components/my-button/MyButton";
import MyInputField from "../../styles/common-components/my-input-field/InputField";
import MyPanel from "../../styles/common-components/my-panel/MyPanel";
import MyTitle from "../../styles/common-components/my-title/MyTitle";
import {useNavigate} from "react-router-dom";

function AuthorizationPage() {
    const navigate = useNavigate()
    let params = {
        password: null,
        mail: null
    }

    const loginHandler = () => {
        console.log(`http://127.0.0.1:8080/users/login/${params.mail}/${params.password}`)
        fetch(`http://127.0.0.1:8080/users/login/${params.mail}/${params.password}`, {
            method: "GET",
            headers: {"Content-Type": "application/json"}
        })
            .then(value => {
                console.log(value)
                if (value.status === 200) {
                    navigate('/main-writer-page')
                }
                return value.json()
            })
            .catch(value => console.log("login error"))
    }

    return (
        <div className="authorization-style-img">
            <div className="authorization-style-gradient">

                <div className="authorization-style-button-position">
                    <MyButton
                        name="To register"
                        path="/main-reader-page/authorization-page/registration-page"
                        backgroundColor="var(--rg-secondary-main)"
                        color="var(--rg-text-secondary)"
                    />
                </div>

                <div className="authorization-style-panel-position">
                    <div className="authorization-page-panel-proportions">
                        <div className="authorization-page-title-wrapper">
                            <MyTitle
                                color=""
                                name="Inspiration"
                            />
                        </div>
                        <MyPanel
                            style="authorization-page-panel-components-wrapper"
                            components={[
                                <MyInputField
                                    name="mail"
                                    backgroundColor="var(--rg-secondary-main)"
                                    params={params}
                                />,
                                <MyInputField
                                    name="password"
                                    backgroundColor="var(--rg-secondary-main)"
                                    params={params}
                                />,
                                <MyButton
                                    name="Login"
                                    path="/main-reader-page/authorization-page"
                                    backgroundColor="var(--rg-secondary-main)"
                                    color="var(--rg-text-secondary)"
                                    handler={loginHandler}
                                />,
                                // <MyLink
                                //     name="forget name"
                                //     path="/main-reader-page/authorization-page/name-restoration"
                                //     color="var(--rg-text-secondary)"
                                // />,
                                // <MyLink
                                //     name="forget password"
                                //     path="/main-reader-page/authorization-page/password-restoration"
                                //     color="var(--rg-text-secondary)"
                                // />
                            ]}
                        />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AuthorizationPage;