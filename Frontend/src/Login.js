import { useState } from "react";
// import './App.css';
import './loginpage.css'
import axios from "axios";
import { useNavigate } from "react-router-dom";
import './DisableRtclick'
import './Loading.css'

function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const navigate=useNavigate();

  const handleEmail = (e) => {
    setEmail(e.target.value)
  }

  const handlePassword = (e) => {
    setPassword(e.target.value)
  }

  const handleApi = async (event) => {
    event.preventDefault()
    try {
      const response  = await  axios.post('http://localhost:8080/course-1/api/employee/login', {
        email: email,
        password: password
      })
      window.localStorage.setItem("user",JSON.stringify(response.data))
      setEmail('')
      setPassword('')
      alert('success')
      navigate('/course')
    }
      catch(exception) {
        alert("service error");
        console.log(exception)
      }
  }


  return (
      <>
        <div id="Box">
          <div id="adminLogin_backgroundImg"></div>
          <section id="adminLogin" className="adminLogin">
            <div className="adminLogin-head">
              <h1>Administrator Login</h1>
              <form id="adminLogin-form">
                <p>
                  <input value={email} type="text" id="adminLogin-email" onChange={handleEmail}  name="email" placeholder="Email ID "
                         title="Please enter Email Id " required/> <br />
                </p>
                <p>
                  <input value={password} id="adminLogin-password" onChange={handlePassword} type="password"  placeholder="Password"  title="Please enter Password"  required/> <br />
                </p>
                <p>
                  <button type="submit" id="adminLogin-login" value="Login" onClick={handleApi}>Login</button>

                </p>
              </form>

            </div>
          </section>
        </div>
      </>
  )
}

export default Login;