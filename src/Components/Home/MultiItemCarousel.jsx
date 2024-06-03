import React from 'react'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from 'react-slick';
import { topmeals } from './topmeals';
import CarouselItem from './CarouselItem';

const MultiItemCarousel = () => {
    const settings = {
        dots: true,
        infinite: true,
        slidesToShow: 5,
        slidesToScroll: 3,
        autoplay: true,
        speed: 3000,
        autoplaySpeed: 3000,
        arrows:false,
        cssEase: "linear"
      };
  return (
    <div>
        <Slider {...settings}>
            {topmeals.map((item)=>
            <CarouselItem 
            image={item.image} 
            title={item.title}/>)}
        </Slider>
    </div>
  )
}

export default MultiItemCarousel