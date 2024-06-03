import React from 'react';
import { Box, Modal } from '@mui/material';
import { useLocation, useNavigate } from 'react-router-dom';
import RegistrationForm from './RegistrationForm';
import LoginForm from './LoginForm';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

const Auth = () => {
    const location = useLocation();
    const navigate = useNavigate();

    const handleClose = () => {
        navigate('/'); // Navigate to the home page on modal close
    };

    return (
        <Modal
            open={location.pathname === "/account/register" || location.pathname === "/account/login"}
            onClose={handleClose}
        >
            <Box sx={style}>
                {location.pathname === "/account/register" ?<RegistrationForm/> : <LoginForm/>}
            </Box>
        </Modal>
    );
};

export default Auth;
