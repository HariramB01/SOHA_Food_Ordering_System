import React, { useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import Address from './Address';
import Events from './Events';
import Favorites from './Favorites';
import Orders from './Orders';
import ProfileNavigation from './ProfileNavigation';
import UserProfile from './UserProfile';

const Profile = () => {
    const [openSideBar, setOpenSideBar] = useState(false);
    return (
        <div className='lg:flex justify-between'>
            <div className='sticky -[80vh] lg:w-[20%]'>
                <ProfileNavigation open={openSideBar}/>
            </div>
            <div className='lg:w-[80%]'>
                <Routes>
                    <Route path='/' element={<UserProfile/>}/>
                    <Route path='/orders' element={<Orders/>}/>
                    <Route path='/address' element={<Address/>}/>
                    <Route path='/favorites' element={<Favorites/>}/>
                    <Route path='/events' element={<Events/>}/>
                </Routes>
            </div>
        </div>
    );
}

export default Profile;
