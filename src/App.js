import { CssBaseline, ThemeProvider } from '@mui/material';
import './App.css';
import Cart from './Components/Cart/Cart';
import Home from './Components/Home/Home';
import { Navbar } from './Components/Navbar/Navbar';
import Profile from './Components/Profile/Profile';
import RestaurantDetails from './Components/Restaurant/RestaurantDetails';
import CustomerRoute from './Components/Routers/CustomerRoute';
import { darkTheme } from './Theme/DarkTheme';

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      {/* <Navbar />
      <Home/>
      <RestaurantDetails />
      <Cart/>
      <Profile/> */}
      <CustomerRoute/>
    </ThemeProvider>
  );
}

export default App;
