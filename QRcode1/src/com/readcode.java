package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.*;

public class readcode {

	
	public static void main(String[] args) throws IOException {
		String txt ="iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQAQAAAACoxAthAAABZElEQVR4Xu3W0WrDMAxG4UAfzK+eBwt0sSzJTtJS/wm7O4cyhK1vV6bb8pZbzge/g6hB1CBqEDWIGkQNogZRg6hB1CBqELVO1iV6xZyDzRDIUxKH+zB+TreQnCA5zJP6CC+beRhBPtxCrofRF7LUCgTyb6SfXA4hOV1vIdfDE8lhXyubP8vTLSQnSA6zZInaa2yf4RACeUgObae1McinIBNkbf+ztc3Nv/racOQQD1JE8rartul8+AIsfQ8SQW6QWKjDkQ9BIsgtsv/0TeP9sO9BIohI6muMB5lDMQspuQeJbpCxte3bm/S5X0I+BJkh+7n36tf1/PuzhEA0EpurPcU6xMuElNyDRPfIam+yDSVIyQ0P4kGekNpmb9Lyx+lBPMgjEjv1sC+3IB7kBsnBP+1B2tfgEMSD5DBL6qVly3Vz+NuavxCSE0Ql00HUIGoQNYgaRA2iBlGDqEHUIGoQNYjaDfIHGRKyl6L8978AAAAASUVORK5CYII=";
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\ASUS\\Desktop\\NewFolder\\output1.png"));
		byte [] bt=Base64.getDecoder().decode(txt);
		out.write(bt);
	}
	
}
