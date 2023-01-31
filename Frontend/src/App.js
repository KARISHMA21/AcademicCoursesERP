import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Courselisting from './Courselisting';
//Emplisting
import CourseEdit from './CourseEdit';
//EmpEdit
import Login from './Login';
import Page404 from './Page404';
function App() {
  return (
    <>
      <div className="App"> 
        <BrowserRouter>
        <Routes>
          <Route path='/' element={<Login/>}></Route>
          <Route path='/course' element={<Courselisting/>}></Route>
          <Route path='/course/edit/:courseid' element={<CourseEdit/>}></Route>
          <Route path="*" element={<Page404/>} />
        </Routes>
      </BrowserRouter>
      </div>
    </>
  );
}

export default App;
