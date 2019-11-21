import React from "react";
import GridItem from "components/Grid/GridItem.js";
import GridContainer from "components/Grid/GridContainer.js";
import Card from "components/Card/Card.js";
import CardHeader from "components/Card/CardHeader.js";
import CardBody from "components/Card/CardBody.js";

import { makeStyles } from "@material-ui/core/styles";
import Primary from "components/Typography/Primary";

const styles = {
    textCenter: {
        textAlign: "center"
    },
};

const useStyles = makeStyles(styles);


export default function Home() {
    const classes = useStyles();

    return (
        <GridContainer>
            <GridItem xs={12} sm={12} md={12}>
                <Card>
                    <CardHeader color="warning">
                        <h3 className={classes.cardTitleWhite, classes.textCenter}>Welcome to Plan Easily</h3>
                    </CardHeader>
                    <CardBody className={classes.textCenter}>
                        <h5>Created By:</h5>
                        <div style={{color:"#3986DD"}}>

                            <h4>Adam Jonhs</h4>
                            <h4>Diane Nguyen</h4>
                            <h4>Nick Soultanian</h4>
                            <h4>Theresa Van</h4>
                            <h4>Annie Wu</h4>
                        </div>
                    </CardBody>

                </Card>
            </GridItem>
        </GridContainer>

        // <div className={classes.textCenter}>
        //     Welcome to Plan Easily
        //     </div>
    )
}
