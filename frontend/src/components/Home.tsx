import React from "react"
import Header from "./Header";
import Footer from "./Footer";
import Content from "./Content";

export default function Home() {

    return (
        <div className="App">
            <Header />
            <Content />
            <Footer />
        </div>
    )
}