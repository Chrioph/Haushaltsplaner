import React from "react";

export default function Tasks() {
    const taskList = [{"id":21,"title":"Deianeira","description":"Emirati","startTime":"2022-01-15T17:13:54.136937","duration":86,"repitition":"TWO_TIMES_PER_WEEK","assignedTo":{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},"household":{"id":17,"name":"Rhoda Booke","users":[{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},{"id":2,"username":"tyson.strosin","email":"Abraham.Powlowski@gmail.com","password":"f7d82ce8-2f2a-4083-b243-2ad304ccbee0"}]}},{"id":22,"title":"Alcestis","description":"Lebanese","startTime":"2022-01-15T17:13:54.141925","duration":37,"repitition":"EVERY_OTHER_DAY","assignedTo":{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},"household":{"id":17,"name":"Rhoda Booke","users":[{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},{"id":2,"username":"tyson.strosin","email":"Abraham.Powlowski@gmail.com","password":"f7d82ce8-2f2a-4083-b243-2ad304ccbee0"}]}},{"id":23,"title":"Arachne","description":"Aromanian","startTime":"2022-01-15T17:13:54.143919","duration":49,"repitition":"WEEKLY","assignedTo":{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},"household":{"id":17,"name":"Rhoda Booke","users":[{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},{"id":2,"username":"tyson.strosin","email":"Abraham.Powlowski@gmail.com","password":"f7d82ce8-2f2a-4083-b243-2ad304ccbee0"}]}},{"id":24,"title":"Atalanta","description":"Brazilian","startTime":"2022-01-15T17:13:54.145915","duration":68,"repitition":"DAILY","assignedTo":{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},"household":{"id":17,"name":"Rhoda Booke","users":[{"id":1,"username":"monte.gerlach","email":"Todd.Gulgowski@gmail.com","password":"c566f2eb-23b1-49fe-9ac6-009ea7fc5b4c"},{"id":2,"username":"tyson.strosin","email":"Abraham.Powlowski@gmail.com","password":"f7d82ce8-2f2a-4083-b243-2ad304ccbee0"}]}}]

    const taskElements = taskList.map(({title, description}) =>
        <div key={title}><label>{title}</label>: <label>{description}</label></div>
    )

    return (
        <div>
            {taskElements}
        </div>

    )
}