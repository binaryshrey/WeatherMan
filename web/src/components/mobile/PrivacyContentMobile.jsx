import React from "react";
import { Link } from "gatsby";
import db from "../../data/db.json";
import Box from "@mui/material/Box";
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Typography from "@mui/material/Typography";




const PrivacyContentMobile = () => {

    const contactButton = () => {
    	window.location.href = `mailto:${db.contact}`
  	}

    return(
            <div style={{ backgroundImage: 'url(https://cdn.jsdelivr.net/gh/binaryshrey/Pokedex@main/static/web_bg_mobile.webp)', backgroundSize: 'cover', backgroundPosition: 'center', backgroundRepeat: 'repeat', width:'100vw',height:'100vh', display:'flex',overflow:'hidden', flexDirection:'column'}}>

                <div style={{flex: 0}}>
                    <div style={{padding:'0.4rem', display: 'flex', justifyContent:'center'}}>
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
                    <Box sx={{ width: "80%", height: "100vh", marginLeft: "10%" , marginRight:"10%",  marginTop:"6rem", marginBottom:"6rem", flexGrow:1}} >
                        
                        <Typography variant="h5" component="div" sx={{fontWeight:'bold'}}>
                            Privacy Policy
                        </Typography>
                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', opacity:"0.8"}}>
                            Updated: July 15, 2023
                        </Typography>
                            
                            

                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', opacity:"0.8"}}>
                            Zén Studio built the Pokédex app as a free app. This service is provided by Zén Studio at no cost for all the features of the app.

                            This page is used to inform visitors regarding our policies with the collection, use, and disclosure of Personal Information if anyone decided to use our service.

                            If you choose to use our service, then you agree to the collection and use of information in relation to this policy. The Personal Information that we collect is used for providing and improving the Service. We will not use or share your information with anyone except as described in this Privacy Policy.

                            The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which are accessible at Pokédex app unless otherwise defined in this Privacy Policy. Please take a moment to get to know our practices and contact us if you have any questions.
                        </Typography>

                            
                            
                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Collection and Use of Personal Information
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            For providing a better experience, while using our service, we may require you to provide us with certain personally identifiable information. The information that we request will be retained by us and used as described in this privacy policy. We may collect user data such as Name, Email address, User IDs for App functionality, Analytics and Personalization.
                            <br/>In accordance with Google Play user's data policy for account deletion, we provide in-app links for account deletion and its associated data.

                            <br/>The app does use third-party services that may collect information used to identify you.

                            <br/>Link to the privacy policy of third-party service providers used by the app
                            <ul>
                                <li><a href="https://www.google.com/policies/privacy/" target="_blank" rel="noreferrer" style={{textDecoration:"None", color:"white"}}>Google Play Services</a></li>
                                <li><a href="https://firebase.google.com/policies/analytics" target="_blank" rel="noreferrer" style={{textDecoration:"None", color:"white"}}>Google Analytics for Firebase</a></li>
                            </ul>
                        </Typography>


                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Cookies and Other Technologies
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            Our website, services, apps and email communications may use “cookies” and other technologies.
                            We use the information we collect in this manner to better understand our user's interaction with our website and to optimize the user experience. You can disable cookies in your browser settings, but please note that certain features on our website may not be available as a result.
                            We use this information to help us determine interest in particular topics and improve the effectiveness of our communications, and to reduce or eliminate messages sent to customers.
                            We use this information in anonymized form for statistical analysis, to administer our site, and to improve our product and services, without directly associating this data with individual users.
                        </Typography>




                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Service Providers
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            We may employ third-party companies and individuals due to the following reasons:
                            <ul>
                                <li>To facilitate our service</li>
                                <li>To provide the service on our behalf</li>
                                <li>To perform service-related services</li>
                                <li>To assist us in analyzing how our Service is used</li>
                            </ul>
                            We want to inform users of this Service that these third parties have access to their Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.
                        </Typography>





                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Security
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            We value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and we cannot guarantee its absolute security.
                        </Typography>




                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Links to Other Sites
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            This Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by us. Therefore, we strongly advise you to review the Privacy Policy of these websites. We have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.
                        </Typography>



                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Children’s Privacy
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            These Services do not address anyone under the age of 13. We do not knowingly collect personally identifiable information from children under 13 years of age. In the case we discover that a child under 13 has provided us with personal information, we immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact us so that we will be able to do the necessary actions.
                        </Typography>




                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Changes to This Privacy Policy
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            We may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. We will notify you of any changes by posting the new Privacy Policy on this page.
                            This policy is effective as of 2023-07-15
                        </Typography>




                        <Typography variant="body2" component="div" sx={{marginTop:'1rem', fontWeight:'bold'}}>
                            <br/><br/>Contact Us
                        </Typography>
                        <Typography variant="body2" component="div" sx={{ opacity:"0.8"}}>
                            If you have any questions or suggestions about our Privacy Policy, do not hesitate to contact us at  
                            <a href={db.contact}target="_blank" rel="noreferrer" style={{textDecoration:"None", color:"white"}}> connect.zenstudio@gmail.com</a>
                            . This privacy policy page was created at 
                                <a href="https://app-privacy-policy-generator.nisrulz.com/" target="_blank" rel="noreferrer" style={{textDecoration:"None", color:"white"}}> App Privacy Policy Generator</a>
                        </Typography>
                    </Box>
                </div>
            </div>
    )
}

export default PrivacyContentMobile