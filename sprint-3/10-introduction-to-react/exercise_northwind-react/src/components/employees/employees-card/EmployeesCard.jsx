import './EmployeesCard.css'


export default function EmployeesCard({id, employee, title}) {
    const imageUrl = `images/employees/${id}.webp`

    return (
        <div className="employee-row">
            <img id="employee-image" src={imageUrl}/>
            <div className="employee-name">
                <h1>{employee}</h1>
                <h6>{title}</h6>
            </div>
        </div>





    );
}