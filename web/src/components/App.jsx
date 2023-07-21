import React from "react";
import MobileLayout from "./mobile/MobileLayout";
import DesktopLayout from "./DesktopLayout";
 import { useMediaQuery } from "react-responsive"

const App = () => {

	const isDesktop = useMediaQuery({
		query: "(min-width: 851px)",
	})

  	const isMobile = useMediaQuery({
    	query: "(max-width: 850px)",
  	})

	return (
		<>
			{isDesktop && <DesktopLayout/>}
			{isMobile && <MobileLayout />}
    	</>
	);
};

export default App;
