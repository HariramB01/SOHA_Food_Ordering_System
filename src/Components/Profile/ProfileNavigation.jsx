import React from 'react'
import HomeIcon from '@mui/icons-material/Home';
import LogoutIcon from '@mui/icons-material/Logout';
import PaymentIcon from '@mui/icons-material/Payment';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import EventIcon from '@mui/icons-material/Event';
import NotificationsIcon from '@mui/icons-material/Notifications';
import { Divider, Drawer, useMediaQuery } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const menu = [
    { title: "Orders", icon: <ShoppingBagIcon /> },
    { title: "Favorites", icon: <FavoriteIcon /> },
    { title: "Address", icon: <HomeIcon /> },
    { title: "Payment", icon: <PaymentIcon /> },
    { title: "Notification", icon: <NotificationsIcon /> },
    { title: "Events", icon: <EventIcon /> },
    { title: "Logout", icon: <LogoutIcon /> },

]


const ProfileNavigation = ({ open, handleClose }) => {
    const isSmallScreen = useMediaQuery('(max-width:600px)');

    const navigate = useNavigate();

    const handleNavigate = (item) =>{
navigate(`/my-profile/${item.title.toLowerCase()}`)
    }


    return (
        <div>
            <Drawer variant={isSmallScreen ? "temporary" : "permanent"}
                onClose={handleClose}
                 open={isSmallScreen ? open : true}
                anchor='left' sx={{ zIndex: -1, position:"sticky" }}>
                    <div className='w-[50vw] lg:w-[20vw] h-[75vh] flex flex-col
                    justify-center text-xl pt-16 gap-8 mt-20'>
                        {menu.map((item,i)=>
                        <>
                        <div onClick={()=>handleNavigate(item)} className='px-5 flex items-center space-x-5 cursor-pointer'>
                            {item.icon}
                            <span>{item.title}</span>
                        </div>{i!==menu.length-1 && <Divider/>}
                        </>)}
                    </div>

            </Drawer>
        </div>
    )
}

export default ProfileNavigation