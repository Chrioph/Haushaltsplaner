import React from "react";

export default function Tasks() {
    const taskList = [{name: "Task1", description: "Description"}, {name: "Task2", description: "Desc2"}]

    const taskElements = taskList.map(({name, description}) =>
        <div key={name}><label>{name}</label>: <label>{description}</label></div>
    )

    return (
        <div>
            {taskElements}
        </div>

    )
}