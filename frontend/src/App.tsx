import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Tasks from "./components/Tasks";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HouseholdOverviewComponent from "./components/HouseholdOverviewComponent";
import ProfileOverviewComponent from "./components/ProfileOverviewComponent";
import BalanceComponent from "./components/BalanceComponent";
import Home from "./components/Home";

function App() {
    return (
        <>
            <Router>
                <Routes>
                    <Route path="/home" element={<Home />}/>
                    <Route path="/household" element={<HouseholdOverviewComponent/>}/>
                    <Route path="/profile" element={<ProfileOverviewComponent/>}/>
                    <Route path="/all-tasks" element={<Tasks/>}/>
                    <Route path="/balance" element={<BalanceComponent/>}/>
                </Routes>
            </Router>
        </>
    )
        ;
}

export default App;
