import React from 'react'
import './NavBar.css'
import { useState } from 'react';
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';
import "bootstrap/dist/css/bootstrap.min.css"
import {FaSearch} from "react-icons/fa"
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';

function NavBar() {
  const [formData, setFormData] = useState({
    name: '',
    place: '',
    type: '',
    warranty:''
  });

  const handleInputChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value
    });
  };

  const handleSubmit = (event) => {
    
    // Do something with the form data, such as storing it in a state variable or sending it to an API
    console.log(formData);
    // Reset the form data and close the popup
    setFormData({
      name: '',
      place: '',
      type: '',
      warranty: ''
    });
   
  };
 


  return (

    <div fluid className='gx-0' id="navbar">
   <Popup trigger={<button className='navbar-item' id='add-btn'>Add Items</button>}
   position="right center">
    <div>
      <h6>Add Item:</h6>
      <form onSubmit={handleSubmit}>
        <label>Name:
        <input type="text" name="name" value={formData.name} onChange={handleInputChange} />
        </label>

        <label>place:
        <input type="text" name="place" value={formData.place} onChange={handleInputChange} />
        </label>

        <label>type:
        <input type="text" name="type" value={formData.type} onChange={handleInputChange} />
        </label>

        <label>warranty:
        <input type="text" name="warranty" value={formData.warranty} onChange={handleInputChange} />
        </label>
        
        <div>
        <button type='submit' onClick={() =>handleSubmit()}>Add</button>
        </div>

        </form>
    </div>
    
   </Popup>

    <DropdownButton className='navbar-item' id="dropdown-basic-button" title="Search By?">
      <Dropdown.Item >Name</Dropdown.Item>
      <Dropdown.Item >Place</Dropdown.Item>
      <Dropdown.Item >Warranty</Dropdown.Item>
    </DropdownButton>
    
    <div className="search-box">
    <button className="btn-search"> <FaSearch /> </button>
    <input type="text" className="input-search" placeholder="Type to Search..." />
    </div>

    </div>
    
  
  )
}

export default NavBar