import React from "react";
import { Link } from "gatsby";
import db from "../data/db.json";
import Box from "@mui/material/Box";
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Typography from "@mui/material/Typography";

const AccountDeletionRedirect = () => {

    const [countdown, setCountdown] = React.useState(5);
    React.useEffect(() => {
        const timer = setInterval(() => {
            setCountdown((prevCountdown) => prevCountdown - 1);
        }, 1000);

        if (countdown === 0) {
            clearInterval(timer);
            window.location.href = 'https://forms.fillout.com/t/ov71efGkmkus';
        }
   
        return () => clearInterval(timer);
    }, [countdown]);


    const contactButton = () => {
    	window.location.href = `mailto:${db.contact}`
  	}

	return (
        <div style={{ backgroundImage: 'url(https://cdn.jsdelivr.net/gh/binaryshrey/Pokedex@main/static/web_bg.webp)', backgroundSize: 'cover', backgroundPosition: 'center', backgroundRepeat: 'repeat', width:'100vw',height:'100vh', display:'flex',overflow:'hidden', flexDirection:'column'}}>
            <div style={{flex: 0}}>
                <div style={{padding:'0.8rem', display: 'flex', justifyContent:'center'}}>
                    <Stack spacing={2} direction="row" >
                        <Link to="/" target="_blank" style={{ textDecoration: "none"}}>
                            <Button variant="text" size="small" sx={{color:"white", fontSize:'12px'}} style={{textTransform: 'none'}}>Home</Button>
                        </Link>
                        <Link to="/privacy" target="_blank" style={{ textDecoration: "none"}}>
                            <Button variant="text" size="small" sx={{color:"white", fontSize:'12px'}} style={{textTransform: 'none'}}>Privacy</Button>
                        </Link>
                        <Link to="/terms" target="_blank" style={{ textDecoration: "none"}}>
                            <Button variant="text" size="small" sx={{color:"white", fontSize:'12px'}} style={{textTransform: 'none'}}>Terms</Button>
                        </Link>
                        <Button variant="text" size="small" sx={{color:"white", fontSize:'12px'}} style={{textTransform: 'none'}} onClick={contactButton} >Contact</Button>
                    </Stack>
                </div>
                <div style={{border:'0.5px solid #2D2d2d'}}/>
            </div>

            <div style={{flex: 1, overflowY:'scroll'}}>
                <Box sx={{  marginTop:"8rem", display:'flex',justifyContent:'center'}} >
                    <Typography variant="h6" component="div" >
                        Adherence to Google Play's Data Safety Policy 🔖
                    </Typography>
                </Box>
                <Box sx={{  marginTop:"2rem", display:'flex',justifyContent:'center'}} >
                    <Typography variant="body2" component="div" sx={{marginTop:'2rem'}}>
                        Redirecting in {countdown}
                    </Typography>
                </Box>
            </div>
        </div>
    )
};

export default AccountDeletionRedirect;
