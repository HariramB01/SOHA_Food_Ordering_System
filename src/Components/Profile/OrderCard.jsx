import { Button, Card } from '@mui/material'
import React from 'react'

const OrderCard = () => {
    return (
        <Card className='flex items-center justify-between p-5'>
            <div className='flex items-center space-x-5'>
                <img className='h-16 w-16'
                    src="https://images.pexels.com/photos/580612/pexels-photo-580612.jpeg?auto=compress&cs=tinysrgb&w=800"
                    alt="" />
                <div>
                    <p>Biryani</p>
                    <p>$399</p>
                </div>
            </div>
            <div>
                <Button variant='outlined' className='cursor-not-allowed'>Completed</Button>
            </div>

        </Card>
    )
}

export default OrderCard