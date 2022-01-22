import React from 'react';
import './App.css';
import AddTask from "./components/AddTask";
import 'bootstrap/dist/css/bootstrap.min.css';
import Tasks from "./components/Tasks";

function App() {
    return (
        <div className="App">
            <h1>Housekeeping Planner</h1>
            <Tasks/>
            <AddTask/>
        </div>
    );
}

export default App;
