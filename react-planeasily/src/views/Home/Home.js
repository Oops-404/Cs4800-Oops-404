import React from "react";
import { makeStyles } from "@material-ui/core/styles";

const styles = {
    textCenter: {
        textAlignVertical: "center"
    },
  };

const useStyles = makeStyles(styles);


export default function Home() {
    const classes = useStyles();

    return(
        <div className={classes.textCenter}>
            Welcome to Plan Easily
            </div>
    )
}
