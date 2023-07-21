import React from "react";
import darkTheme from "../utils/appTheme";
import PrivacyContent from "./PrivacyContent";
import { useMediaQuery } from "react-responsive"
import CssBaseline from "@mui/material/CssBaseline";
import { ThemeProvider } from "@mui/material/styles";
import PrivacyContentMobile from "./mobile/PrivacyContentMobile";




const PrivacyContainer = () => {

    const isDesktop = useMediaQuery({
		query: "(min-width: 1001px)",
	})

    const isMobile = useMediaQuery({
    	query: "(max-width: 1000px)",
  	})

    return(
        <>
            <ThemeProvider theme={darkTheme}>
                    <CssBaseline />
                    {isDesktop && <PrivacyContent/>}
			        {isMobile && <> <PrivacyContentMobile/>
                    </>}
            </ThemeProvider>
        </>
    )
}

export default PrivacyContainer