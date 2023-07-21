import React from "react";
import db from "../../data/db.json";
import Button from '@mui/material/Button';
import Typography from "@mui/material/Typography";
import GitHubIcon from '@mui/icons-material/GitHub';
import DownloadRoundedIcon from '@mui/icons-material/DownloadRounded';



const MobileLayout = () => {

	const downloadButton = () => {
    	window.open(`${db.download}`, '_blank');
  	}
	const githubButton = () => {
    	window.open(`${db.github}`, '_blank');
  	}

	return (
		<div style={{ backgroundImage: 'url(https://cdn.jsdelivr.net/gh/binaryshrey/Pokedex@main/static/web_bg_mobile.webp)', backgroundSize: 'cover', backgroundPosition: 'center', backgroundRepeat: 'no-repeat', width:'100vw',height:'100vh', overflow:'hidden'}}>
			<div style={{height: '100vh', display: 'flex', flexDirection:'column'}}>
				<div style={{ flex: 1}}>
					<div style={{marginTop:'4rem', display: 'flex', justifyContent:'center'}}>
						<img alt="logo" src="logo.webp" height="50rem"  />
					</div>
					<div style={{marginTop:'2rem', display: 'flex', justifyContent:'center'}}>
						<Typography variant="h3" component="div" fontWeight={500} >
							{db.appName}
						</Typography>
					</div>
					<div style={{marginTop:'1rem', display: 'flex', justifyContent:'center', marginLeft:'2rem',marginRight:'2rem'}}>
						<Typography variant="body1" component="div" fontWeight={500} sx={{textAlign: 'center'}}>
							{db.description}
						</Typography>
					</div>
					<div style={{marginTop:'2rem', display: 'flex', justifyContent:'center', flexDirection:'column', marginLeft:'5rem',marginRight:'5rem'}}>
							<Button variant="contained" startIcon={<DownloadRoundedIcon/>} onClick={downloadButton} size="large" sx={{backgroundColor:'white', '&:hover': {backgroundColor: '#d0d0d0', color: 'black', }}}  style={{textTransform: 'none'}}>Download</Button>
							<Button variant="outlined"  startIcon={<GitHubIcon/>} onClick={githubButton} size="large" sx={{borderColor:'white',color:'white' ,'&:hover': {borderColor:'#d0d0d0',color:'white' }, marginTop:'0.5rem'}} style={{textTransform: 'none'}}>&nbsp;&nbsp;&nbsp;Github&nbsp;&nbsp;</Button>
					</div>
				</div>


				<div style={{alignSelf: 'flex-end', marginTop:'1rem'}}>
					<div style={{ display: 'flex', justifyContent:'center'}}>
						<img alt="weatherman" src="weatherman.webp"  style={{width:'100vw'}}  />
					</div>
				</div>
			</div>
		</div>
	);
};

export default MobileLayout;
