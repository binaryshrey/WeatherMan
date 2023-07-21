import React from "react";
import { Link } from "gatsby";
import db from "../data/db.json";
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Typography from "@mui/material/Typography";
import GitHubIcon from '@mui/icons-material/GitHub';
import ShopRoundedIcon from '@mui/icons-material/ShopRounded';



const Desktoplayout = () => {

	const contactButton = () => {
    	window.location.href = `mailto:${db.contact}`
  	}
	const downloadButton = () => {
    	window.open(`${db.download}`, '_blank');
  	}
	const githubButton = () => {
    	window.open(`${db.github}`, '_blank');
  	}

	return (
		<div style={{ backgroundImage: 'url(https://cdn.jsdelivr.net/gh/binaryshrey/Pokedex@main/static/web_bg.webp)', backgroundSize: 'cover', backgroundPosition: 'center', backgroundRepeat: 'no-repeat', width:'100vw',height:'100vh'}}>
			<div style={{height: '100vh', display: 'flex', flexDirection:'column'}}>
				<div style={{height:'50vh'}}>

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
					<div style={{marginTop:'3rem', display: 'flex', justifyContent:'center'}}>
						<img alt="logo" src="logo.webp" height="50rem"  />
					</div>
					<div style={{marginTop:'2rem', display: 'flex', justifyContent:'center'}}>
						<Typography variant="h3" component="div" fontWeight={500} >
							{db.appName}
						</Typography>
					</div>
					<div style={{marginTop:'1rem', display: 'flex', justifyContent:'center'}}>
						<Typography variant="body2" component="div" fontWeight={500} >
							{db.description}
						</Typography>
					</div>
					<div style={{marginTop:'0rem', display: 'flex', justifyContent:'center'}}>
						<Typography variant="body2" component="div" fontWeight={500} >
							{db.description_next}
						</Typography>
					</div>
					<div style={{marginTop:'2rem', display: 'flex', justifyContent:'center'}}>
						<Stack spacing={2} direction="row">
							<Button variant="contained" startIcon={<ShopRoundedIcon/>} onClick={downloadButton} sx={{backgroundColor:'white', '&:hover': {backgroundColor: '#d0d0d0', color: 'black', }}}  style={{textTransform: 'none'}}>Download</Button>
							<Button variant="outlined"  startIcon={<GitHubIcon/>} onClick={githubButton} sx={{borderColor:'white',color:'white' ,'&:hover': {borderColor:'#d0d0d0',color:'white' }}} style={{textTransform: 'none'}}>Github</Button>
						</Stack>
					</div>
				</div>


				<div style={{height:'50vh'}}>
					<div style={{ display: 'flex', justifyContent:'center'}}>
						<img alt="pokedex" src="pokedex.webp"  style={{maxHeight:'50vh'}} />
					</div>
				</div>
			</div>
		</div>
	);
};

export default Desktoplayout;
