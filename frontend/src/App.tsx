import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Tasks from "./components/Tasks";
import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom";
import WeeklyOverviewComponent from "./components/WeeklyOverviewComponent";
import HouseholdOverviewComponent from "./components/HouseholdOverviewComponent";
import ProfileOverviewComponent from "./components/ProfileOverviewComponent";

function App() {
    return (
        <>
            <Router>
                <div className="App">
                    <h1>Housekeeping Planner</h1>
                    <Link to="/home">Home</Link>

                </div>
                <Routes>
                    <Route path="/home" element={<WeeklyOverviewComponent/>}/>
                    <Route path="/household" element={<HouseholdOverviewComponent/>}/>
                    <Route path="/profile" element={<ProfileOverviewComponent/>}/>
                    <Route path="/all-tasks" element={<Tasks/>}/>
                </Routes>
            </Router>
        </>
    )
        ;
}

export default App;
