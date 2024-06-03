import { Divider, FormControl, FormControlLabel, Grid, Radio, RadioGroup, Typography } from '@mui/material'
import React from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import { useState } from 'react';
import MenuCard from './MenuCard';


const categories = [
    "pizza",
    "biryani",
    "burger",
    "chicken",
    "rice"
]

const foodTypes = [
    { label: "All", value: "all" },
    { label: "Vegetarian only", value: "Vegetarian" },
    { label: "Non-Vegetarian", value: "non_vegetarian" },
    { label: "Seasonal", value: "seasonal" }
]

const menu = [1,1,1,1,1]

const RestaurantDetails = () => {
    const [foodType, setFoodType] = useState("all")
    const handleFilter=(e)=>{
        console.log(e.target.value, e.target.name)
    }
    return (
        <div className='px-5 lg:px-20 '>
            <section>
                <h3 className='text-gray-500 py-2 mt-10'>Home/India/Indian Fast Food/3</h3>
                <div>
                    <Grid container space={2}>
                        <Grid item xs={12} pb={3}>
                            <img className='w-full h-[40vh] object-cover'
                                src="https://images.pexels.com/photos/1841184/pexels-photo-1841184.jpeg?auto=compress&cs=tinysrgb&w=800"
                                alt="" />
                        </Grid>
                        <Grid item xs={12} lg={6} pr={3}>
                            <img className='w-full h-[40vh] object-cover'
                                src="https://images.pexels.com/photos/1267320/pexels-photo-1267320.jpeg?auto=compress&cs=tinysrgb&w=800"
                                alt="" />
                        </Grid>
                        <Grid item xs={12} lg={6} >
                            <img className='w-full h-[40vh] object-cover'
                                src="https://images.pexels.com/photos/1850600/pexels-photo-1850600.jpeg?auto=compress&cs=tinysrgb&w=800"
                                alt="" />
                        </Grid>
                    </Grid>
                </div>
                <div className='pt-3 pb-5'>
                    <h1 className='text-4xl font-semibold'>Indian Fast Food</h1>
                    <p className='text-gray-500 mt-1'>We deserve to serve you</p>
                    <div className='space-y-3 mt-3'>
                        <p className='text-gray-500 flex items-center gap-3'>
                            <LocationOnIcon />
                            <span>
                                Vellore, TamilNadu
                            </span>
                        </p>
                        <p className='text-gray-500 flex items-center gap-3'>
                            <CalendarMonthIcon />
                            <span>
                                Mon - Sun: 9:00 AM - 9:00 PM (Today)
                            </span>
                        </p>
                    </div>
                </div>
            </section>
            <Divider />
            <section className='pt-[2rem] lg:flex relative'>
                <div className='space-y-10 lg:w-[20%] filter'>
                    <div className='box space-y-5 lg:sticky top-28'>
                        <div>
                            <Typography variant="h5" sx={{ paddingBottom: "1rem" }}>Food Type</Typography>
                            <FormControl className='py-10 space-y-5' component={"fieldset"}>
                                <RadioGroup onChange={handleFilter} name='food_type' value={foodType}>
                                    {foodTypes.map((item) =>
                                    (<FormControlLabel
                                        key={item.value}
                                        value={item.value}
                                        control={<Radio />}
                                        label={item.label}
                                    />
                                    ))}
                                </RadioGroup>
                            </FormControl>
                        </div>
                        <Divider/>
                        <div>
                            <Typography variant="h5" sx={{ paddingBottom: "1rem" }}>Food Category</Typography>
                            <FormControl className='py-10 space-y-5' component={"fieldset"}>
                                <RadioGroup onChange={handleFilter} name='categories' value={foodType}>
                                    {categories.map((item) =>
                                    (<FormControlLabel
                                        key={item}
                                        value={item}
                                        control={<Radio />}
                                        label={item}
                                    />
                                    ))}
                                </RadioGroup>
                            </FormControl>
                        </div>
                    </div>
                </div>
                <div className='space-y-10 lg:w-[80%] lg:pl-10'>
                    {menu.map((item)=><MenuCard/>)}
                </div>
            </section>
        </div>
    )
}

export default RestaurantDetails