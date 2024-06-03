import { TextField, Button, Typography, FormControl, InputLabel, MenuItem, Select, Box } from '@mui/material';
import * as Yup from 'yup';
import { Field, Form, Formik } from 'formik';
import React from 'react';
import { useNavigate } from 'react-router-dom';

const initialValues = {
    fullName: "",
    email: "",
    password: "",
    role: ""
};

const validationSchema = Yup.object().shape({
    fullName: Yup.string().required('Full name is required'),
    email: Yup.string().email('Invalid email format').required('Email is required'),
    password: Yup.string().required('Password is required'),
    role: Yup.string().required('Role is required')
});

const RegistrationForm = () => {
    const navigate = useNavigate();

    const handleSubmit = (values, { setSubmitting }) => {
        console.log(values);
        setSubmitting(false);
    };

    return (
        <Box sx={{ maxWidth: 500, mx: 'auto', p: 3, boxShadow: 3, borderRadius: 2 }}>
            <Typography variant='h5' align='center' sx={{ mb: 2 }}>
                Registration Form
            </Typography>
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={handleSubmit}
            >
                {({ isSubmitting, handleChange, handleBlur, errors, touched }) => (
                    <Form>
                        <Field
                            as={TextField}
                            name="fullName"
                            label="Full Name"
                            fullWidth
                            variant="outlined"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            error={touched.fullName && Boolean(errors.fullName)}
                            helperText={touched.fullName && errors.fullName}
                            margin="normal"
                        />
                        <Field
                            as={TextField}
                            name="email"
                            label="Email"
                            fullWidth
                            variant="outlined"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            error={touched.email && Boolean(errors.email)}
                            helperText={touched.email && errors.email}
                            margin="normal"
                        />
                        <Field
                            as={TextField}
                            name="password"
                            label="Password"
                            fullWidth
                            variant="outlined"
                            type="password"
                            onChange={handleChange}
                            onBlur={handleBlur}
                            error={touched.password && Boolean(errors.password)}
                            helperText={touched.password && errors.password}
                            margin="normal"
                        />

                        <Field
                            fullWidth
                            margin="normal"
                            as={Select}
                            name="role"
                            labelId="role-simple-select-label"
                            id="role-simple-select"
                            label="Role"
                            onChange={handleChange}
                            onBlur={handleBlur}
                        >
                            <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
                            <MenuItem value={"ROLE_RESTAURANT_OWNER"}>Restaurant Owner</MenuItem>
                        </Field>

                        <Button
                            sx={{ mt: 2, padding: "1rem" }}
                            type="submit"
                            variant="contained"
                            color="primary"
                            disabled={isSubmitting}
                            fullWidth
                        >
                            Register
                        </Button>
                    </Form>
                )}
            </Formik>
            <Box sx={{ mt: 3, textAlign: 'center' }}>
                <Typography variant='body2'>
                    If you already have an account?
                    <Button onClick={() => navigate("/account/login")}>Login</Button>
                </Typography>
                <Button onClick={() => navigate("/account/login")} sx={{ mt: 2 }}>Forgot Password</Button>
            </Box>
        </Box>
    );
};

export default RegistrationForm;
