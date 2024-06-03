import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Auth from '../Auth/Auth';
import Cart from '../Cart/Cart';
import Home from '../Home/Home';
import { Navbar } from '../Navbar/Navbar';
import Profile from '../Profile/Profile';
import RestaurantDetails from '../Restaurant/RestaurantDetails';

const CustomerRoute = () => {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/account/:register' element={<Home />} />
        <Route path='/restaurant/:city/:title/:id' element={<RestaurantDetails />} />
        <Route path='/cart' element={<Cart />} />
        <Route path='/my-profile/*' element={<Profile />} />
      </Routes>
      <Auth />
    </div>
  );
};

export default CustomerRoute;
