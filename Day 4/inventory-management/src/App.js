import './App.css';
import Header from './Header';
import NavBar from './NavBar';
import DataTable from './DataTable';
import StudentData from "./Data";
import { useState } from 'react';


function App() {
  const [data, setData] = useState(StudentData);
  return (
    <div className="App">
    <Header />
    <NavBar />
    <DataTable Studentsdata={data} />
    </div>
  );
}

export default App;
