import { Card, CardActions, CardContent, CardMedia, IconButton, Typography } from '@mui/material'
import React from 'react'
import DeleteIcon from '@mui/icons-material/Delete';

const EventCard = () => {
  return (
    <div>
        <Card sx={{width:345}}>
            <CardMedia  sx={{height:345}}
             image='https://images.pexels.com/photos/2454533/pexels-photo-2454533.jpeg?auto=compress&cs=tinysrgb&w=800'/>
                <CardContent >
                    <Typography variant='h5'>
                        Indian Fast Food
                    </Typography>
                    <Typography variant='h5'>
                        50% off of your first order
                    </Typography>
                    <div className='py-5 space-y-2'>
                        <p>{"Vellore"}</p>
                        <p className='text-sm text-blue-500'>June 15, 2024 12:00 AM</p>
                        <p className='text-sm text-red-500'>June 16, 2024 12:00 AM</p>
                    </div>
                </CardContent>
                {false && <CardActions>
                    <IconButton>
                        <DeleteIcon/>
                    </IconButton>
                </CardActions>}
        </Card>
    </div>
  )
}

export default EventCard